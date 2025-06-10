package com.qsvc.finapi.exception;

import org.springframework.http.HttpStatus;

public enum ServiceError {
	INVALID_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "필수 데이터가 누락되었습니다."),
	INCORRECT_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "데이터 형식이 올바르지 않습니다."),
	INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
	NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE, "미등록 상태의 기기입니다. 이 기기로 Qcard 서비스를 이용하도록 기기 정보를 등록하시겠습니까?"),
	BAD_REQUEST(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "요청 오류"),
	NOTFOUND(HttpStatus.NOT_FOUND, "데이터를 찾을 수 없습니다"),
	NO_CONTENT(HttpStatus.NO_CONTENT, "조회할 데이터가 없습니다."),
	CONFLICT(HttpStatus.CONFLICT, "등록 실패"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증 실패"),
	
	FORBIDDEN(HttpStatus.FORBIDDEN, "인증 실패"),
	MISMATCH_USERID(HttpStatus.FORBIDDEN, "사용자 정보가 일치하지 않습니다."),
	INCORRECT_ID_PWD(HttpStatus.FORBIDDEN, "아이디 또는 비밀번호를 확인해 주세요. 총 5회 이상 비밀번호를 잘못 입력한 경우 사용이 제한될 수 있습니다."),
	INCORRECT_OTP(HttpStatus.FORBIDDEN, "인증번호가 올바르지 않습니다."),
	INCORRECT_OTP_LENGTH(HttpStatus.FORBIDDEN, "인증번호 6자리를 입력해 주세요."),
	
	WRONG_RESPONSE(HttpStatus.BAD_GATEWAY, "응답 오류"),
	INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류"),
	UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "외부서비스 오류 응답"),
	UNAVAILABLE_XBUS(HttpStatus.SERVICE_UNAVAILABLE, "카드사 오류 응답"),
	INZICRYPT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "데이터 암복호화에 실패하였습니다"),
	
	/*
	 *  HANA ODS
	 */
//	FILE_NOT_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, "파일이 존재하지 않습니다"),
	MCI_FILEDOWNLOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "MCI 파일 다운로드에 실패하였습니다"),
	INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰"),
	INVALID_META_JSON(HttpStatus.BAD_REQUEST, "META.json의 값이 유효하지 않습니다"),
	/*
	Temporal Error Lists
	 */
	SFTP_CONNECTION_ERROR(HttpStatus.BAD_GATEWAY,"SFTP Connection Error");
	
	private final HttpStatus statusCode;
	
    private final String description;

    private ServiceError(HttpStatus statusCode, String description) {
    	this.statusCode = statusCode;
        this.description = description;
    }

    public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getDescription() {
        return description;
    }
}
