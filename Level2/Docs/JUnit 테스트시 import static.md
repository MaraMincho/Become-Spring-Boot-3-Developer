
MockMvcRequestBuilders의 메서드를 static import로 불러와야 하는 이유는 해당 메서드들이 정적 메서드이기 때문입니다. 일반적인 import와 정적 import의 차이와 MockMvcRequestBuilders의 설계를 이해하면 이 질문에 대한 답이 명확해집니다.

# 1. Static Import란?
Java에서 정적 메서드나 정적 필드를 클래스 이름 없이 바로 사용하려면 static import가 필요합니다.


예를 들어, 정적 메서드를 호출하는 일반적인 방식은 다음과 같습니다:
```java
MockMvcRequestBuilders.post("/api/articles");
```

하지만 static import를 사용하면 클래스 이름 없이도 호출할 수 있습니다:

```java
post("/api/articles");
```


# 2. MockMvcRequestBuilders의 설계

MockMvcRequestBuilders 클래스는 post, get, put, delete 등 HTTP 요청을 생성하는 정적 메서드를 제공합니다. 이 메서드들은 특정 인스턴스에 의존하지 않으며, 클래스 이름으로 직접 호출하도록 설계되었습니다.


이를 정적 메서드로 설계한 이유는:
- HTTP 요청 생성은 별도의 상태를 가지지 않아도 되는 유틸리티 작업이기 때문입니다.
- 이런 유틸리티 메서드는 인스턴스화 없이 사용할 수 있도록 정적 메서드로 제공하는 것이 일반적입니다.

# 3. 왜 일반 import 로는 안될까?

일반 import는 클래스 이름을 가져오는 데 사용됩니다. 예를 들어:
```java
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
```


위와 같이 클래스 이름을 가져오면, 반드시 클래스 이름을 명시하여 정적 메서드를 호출해야 합니다:
```java
MockMvcRequestBuilders.post("/api/articles");
```



하지만, post를 클래스 이름 없이 사용하려면 정적 import를 사용해야 합니다:
```java
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
```


# 4. 정적 import를 사용해야 하는 이유 요약
- MockMvcRequestBuilders.post()는 정적 메서드이므로, 클래스 이름을 생략하려면 static import가 필요합니다.
- 일반 import는 클래스 이름을 가져오는 데 사용되며, 정적 메서드 호출에 적합하지 않습니다.
- 정적 import는 코드 가독성을 높이고 간결하게 작성하도록 도와줍니다

# 5. 정적 import의 장단점
장점 
- 코드가 더 간결해집니다.
```java 
post("/api/articles") // 정적 import 사용
MockMvcRequestBuilders.post("/api/articles") // 정적 import 미사용
```

단점

- 너무 많은 정적 import를 사용하면, 메서드가 어느 클래스에서 왔는지 추적하기 어려워질 수 있습니다. 따라서 적절히 사용하는 것이 중요합니다.