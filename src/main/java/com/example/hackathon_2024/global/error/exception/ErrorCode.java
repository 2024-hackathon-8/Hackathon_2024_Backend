package com.example.hackathon_2024.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // jwt
    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "검증되지 않은 토큰입니다."),
    REFRESH_TOKEN_NOT_FOUND(404, "일치하는 리프레쉬토큰이 존재하지 않습니다."),

    // user
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 일치하지 않습니다."),

    // business
    BUSINESS_NOT_FOUND(404, "비즈니스를 찾을 수 없습니다."),

    // tag
    DUPLICATED_TAG(409, "중복되는 태그가 존재합니다."),

    // invest
    INVEST_NOT_FOUND(404, "해당하는 투자를 찾을 수 없습니다."),

    //image
    IMAGE_UPLOAD_FAIL(400, "이미지 업로드에 실패 했습니다."),
    WRONG_IMAGE(400, "잘못된 이미지 입니다."),

    // general
    BAD_REQUEST(400, "프론트 탓..."),
    INTERNAL_SERVER_ERROR(500, "서버 탓...");

    private final int statusCode;
    private final String message;
}
