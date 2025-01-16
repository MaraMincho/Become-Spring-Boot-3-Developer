package org.example.level2.service;


import lombok.RequiredArgsConstructor;
import org.example.level2.config.jwt.TokenProvider;
import org.example.level2.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private  final RefreshTokenService refreshTokenService;
    private  final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findByID(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
