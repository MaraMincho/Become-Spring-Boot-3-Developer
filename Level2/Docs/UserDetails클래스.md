# UserDetails

User 클래스가 상속한 UserDetails 클래스는 스프링 시큐리티에서 사용자의 인증 정보를 담아
두는 인터페이스입니다. 스프링 시큐리티에서 해당 객체를 통해 인증 정보를 가져오려면 필수 오
버라이드 메서드들을 여러 개 사용해야 합니다.

|메서드| 반환| 타입 설명|
|-:|-:|-:|
|getAuthorities()| Collection<? extendsGrantedAuthority>|사용자가 가지고 있는 권한의 목록을 반환합니다. 현재 예제 코드에서는 사용자 이외의 권한이 없기 때문에 user 권한만 담아 반환합니다.|
|getUsername()| String |사용자를 식별할 수 있는 사용자 이름을 반환합니다. 이때 사용되는 사용자 이름은 반드시 고유해야 합니다. 현재 예제 코드는 유니크 속성이적용된 이메일을 반환합니다.|
|getPassword()| String | 사용자의 비밀번호를 반환합니다. 이때 저장되어 있는 비밀번호는 암호화해서 저장해야 합니다.|
|isAccountNonExpired( ) |boolean| 계정이 만료되었는지 확인하는 메서드입니다. 만약 만료되지 않은 때는true를 반환합니다.|
|isAccountNonLocked()| boolean| 계정이 잠금되었는지 확인하는 메서드입니다. 만약 잠금되지 않은 때는true를 반환합니다.|
|isCredentialsNonExpired( )|boolean| 비밀번호가 만료되었는지 확인하는 메서드입니다. 만약 만료되지 않은때는 true를 반환합니다.|
|isEnabled()| boolean| 계정이 사용 가능한지 확인하는 메서드입니다. 만약 사용 가능하다면true를 반환합니다.|