package config;

public enum BaseResponseMessage {
    // 요청 성공 1000
    REQUEST_SUCCESS(true, 1000, "요청이 정상적으로 처리되었습니다"),

    // 회원 기능 2000
    MEMBER_REGISTER_SUCCESS(true, 2100, "정상적으로 가입되었습니다."),
    MEMBER_REGISTER_FAIL_NAME(false, 2101, "이름을 입력해주세요."),
    MEMBER_REGISTER_FAIL_PASSWORD_EMPTY(false, 2102, "패스워드를 입력해주세요."),
    MEMBER_REGISTER_FAIL_PASSWORD_COMPLEXITY(false, 2103, "패스워드는 8글자 이상 입력해주세요."),
    MEMBER_REGISTER_FAIL_PASSWORD_SPECIAL_CHAR(false, 2104, "패스워드에 1개 이상의 특수문자를 포함해 주세요."),
    MEMBER_REGISTER_FAIL_EMAIL_DUPLICATE(false, 2105, "중복된 이메일입니다."),
    MEMBER_REGISTER_FAIL_EMAIL_AUTHENTICATE(false, 2106, "이메일 인증에 실패했습니다."),
    MEMBER_REGISTER_FAIL_NICKNAME(false, 2107, "중복된 닉네임입니다."),
    MEMBER_REGISTER_FAIL_ADDRESS(false, 2108, "주소를 입력해주세요."),

    MEMBER_LOGIN_SUCCESS(true, 2000, "로그인에 성공했습니다."),
    MEMBER_LOGIN_FAIL(false, 2001, "아이디와 비밀번호가 불일치합니다."),

    MEMBER_SOCIAL_LOGIN_SUCCESS(true, 2002, "소셜 로그인에 성공했습니다."),
    MEMBER_SOCIAL_LOGIN_FAIL(false, 2003, "소셜 로그인에 실패했습니다."),
    MEMBER_SOCIAL_LOGIN_FAIL_NET_INFO(false, 2004, "소셜 네트워크 정보가 없습니다."),

    MEMBER_INFO_UPDATE_SUCCESS(true, 2005, "회원정보 수정에 성공했습니다."),
    MEMBER_INFO_UPDATE_FAIL(false, 2006, "회원정보 수정에 실패했습니다."),

    MEMBER_PHONE_AUTHENTIFICATION_SUCCESS(false, 2007, "회원정보 수정에 실패했습니다."),
    MEMBER_PHONE_AUTHENTIFICATION_FAILED(false, 2008, "인증번호가 일치하지 않습니다."),
    MEMBER_PHONE_AUTHENTIFICATION_EXCEED_TIME_FAILED(false, 2009, "인증 시간이 초과되었습니다."),

    // 게시판 기능 3000
    BOARD_REGISTER_SUCCESS(true, 3000, "게시글이 등록되었습니다."),
    BOARD_REGISTER_FAIL_TITLE(false, 3001, "게시글 제목을 2자 이상 기입해주세요."),
    BOARD_REGISTER_FAIL_CONTENTS(false, 3002, "게시글 내용을 2자 이상 기입해주세요."),

    BOARD_VIEW_FAIL_AUTH(false, 3003, "게시글을 볼 수 있는 권한이 없습니다."),
    BOARD_VIEW_FAIL_DELETED(false, 3004, "삭제된 게시글입니다."),

    BOARD_UPDATE_SUCCESS(true, 3005, "게시글이 수정되었습니다."),
    BOARD_UPDATE_FAIL_TITLE(false, 3006, "게시글 제목을 2자 이상 기입해주세요."),
    BOARD_UPDATE_FAIL_CONTENTS(false, 3007, "게시글 내용을 2자 이상 기입해주세요."),

    BOARD_DELETE_SUCCESS(true, 3008, "게시글 삭제가 완료되었습니다."),

    COMMENT_REGISTER_SUCCESS(true, 3100, "댓글이 등록되었습니다."),
    COMMENT_REGISTER_FAIL(false, 3101, "내용을 기입해주세요."),
    COMMENT_DELETE_SUCCESS(true, 3102, "댓글 삭제가 완료되었습니다."),

    BOARD_SEARCH_FAIL(false, 3200, "검색어를 2자 이상 입력해주세요.");
    private Boolean isSuccess;
    private Integer code;
    private String message;

    BaseResponseMessage(Boolean isSuccess, Integer code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
