package com.qsvc.finapi.eds.exception;

/**
 * Response Code
 * 
 */
public enum EdsStatus {
	
	/*
	 * errorCode = E(EdocServer Process Id) + Number(2) + Number(3)
	 * 
	 * Number(2) : Service Interface 분류 코드
	 * 	00 : Service 공통
	 * 	10 : GenerateEdocKeyService
	 * 	20 : UploadEdocDataService
	 * 	30 : UploadTempDataService
	 * 	40 : SearchTempDataService
	 * 	50 : SearchTempListService
	 * 	60 : EformDownloadService
	 * 
	 * Number(3) : exception 분류 코드
	 */
	
	OK(200, "OK", "SUCCESS"),

	/*
	 * 4XX : client Error
	 */
	BAD_REQUEST(400, "E00400", "Bad Request"),
	
	/* 
	 * 5xx : internal Server error
	 */
	INTERNAL_SERVER_ERROR(500, "E00500", "Unknown Internal Server Error"),
	
	UNKNOWN_HOST_ERROR(500, "E00501", "Unknown Host Exception"),

	FILE_READ_ERROR(510, "E00511", "IOException - File Input Error"),
	
	FILE_WRITE_ERROR(510, "E00512", "IOException - File Output Error"),
	
	FILE_TRANSFER_ERROR(510,"E00513", "MultipartFile Transfer Failed"),
	
	FILE_PARSING_ERROR(510, "E00514", "File Parsing Failed"),
	
	FILE_CONVERT_ERROR(510, "E00515", "File Convert Error"),
	
	FILE_DECOMPRESS_ERROR(510, "E00516", "Zip File Decompress Failed"),
	
	UNSUPPORTED_ENCODING_TYPE(520, "E00521", "Unsupported Encoding Type"),
	
	UNSUPPORTED_MEDIA_TYPE(520, "E00522", "Unsupported Media Type"),
	
	UNSUPPORTED_MIME_TYPE(520, "E00523", "Unsupported Mime Type"),
	
	UNSUPPORTED_TARGET_FILE_FORAMT(520, "E00524", "Unsupported target file format."),
	
	UNSUPPORTED_TARGET_COMPRESS_FORAMT(520, "E00525", "Unsupported target compress format."),
	
	
	/* 
	 * 8xx : handled service error
	 */
	//800 : invalid request
	INVALID_REQUEST(800, "E00800", "Invalid Request. Check parameter validation condition."),
	
	INVALID_EDOC_KEY(800, "E00801", "Invalid EdocGrpIdxNo."),
	
	INVALID_CFG_FILE(800,"E10802", "Result Data.Cfg File Validation Failed"),
	
	INVALID_GUID_FORMCODE_LINK(800, "E10803", "GUID_FORMCODE_LINK Info Validation Failed"),
	
	INVALID_XML_FILE(800, "E10804", "RESULT XML File VALIDATION FAIL"),
	
	XML_FILE_NOT_FOUND(800, "E10805", "Result XML FILE not EXIST"),
	
	INVALID_SCANDATAS(800, "E10806", "SCANDATAS Validation Failed"),

	//810 : Request Data/File Not Found
	NO_TMP_DATA(810, "E40810", "TmpStrgMgmt Data is Not Exist"),
	
	NO_TMP_LIST(810, "E50810", "TmpStrgMgmt List is Not Exist"),
	
	TMP_FILE_NOT_EXIST(810, "E40811", "TmpDataFile is Not Exist"),
	
	FORM_FILE_NOT_EXIST(404, "E60811", "FormFile is Not Exist"),
	
	//820 : already processed edocGroup
	REQUEST_ALREADY_PROCESSING(820, "E10820", "Requested EdocGrpIdxNo Already Processing"),
	
	REQUEST_FILE_ALREADY_PROCESSED(820, "E40820", "Requested Temp File Already Processed"),

	//890 : Access denied
	NO_AUTHORITY(890, "E00890", "No Authority"),


	/* 
	 * 9XX - External service/library error
	 */
	//900 : DB
	DB_CONNECT_ERROR(900, "E00900", "DataBase Connect Failed"),
	
	SQL_ERROR(900, "E00901", "SQL Error"),
	
	DB_INSERT_ERROR(900, "E00902", "Data Insert ERROR"),
	
	DB_UPDATE_ERROR(900, "E00903", "Data Update ERROR"),
	
	DB_DELETE_ERROR(900, "E00904", "Data Delete ERROR"),
	
	DB_SELECT_ERROR(900, "E00905", "Data Select Error"),
	
	
	//910 : crypto
	ENCRYPT_ERROR(910, "E00911", "Encrypt Error"),
	
	DECRYPT_ERROR(910, "E00912", "Decrypt Error"),
	
	FILE_ENCRYPT_ERROR(910, "E00913", "File Encrypt Error"),
	
	FILE_DECRYPT_ERROR(910, "E00914", "File Decrypt Error."),
	
	DATA_ENCRYPT_ERROR(910, "E00915", "Data Encrypt Error"),
	
	DATA_DECRYPT_ERROR(910, "E00916", "Data Decrypt Error"),
	
	
	//920 : syncany receive/receipt error
	RECEIVE_UNKNOWN_ERROR(920, "E00920", "Receive Unknown Error"),		//카드사 응답 오류: 알수없는 오류
	RECEIVE_OPEN_ERROR(920, "E00922", "Receive File Open Error"),		//카드사 응답 오류: 수신파일 오픈오류
	RECEIVE_PROC_ERROR(920, "E00923", "Receive File Process Error"),	//카드사 응답 오류: 수신처리 에러
	RECEIVE_FILE_NONEXIST_ERROR(920, "E00924", "Receive File Not Exist Error"),	//카드사 응답 오류: 파일누락
	RECEIVE_SUBNO_ERROR(920, "E00925", "Receive File Subno Error"),		//카드사 응답 오류: 대체번호 오류
	RECEIPT_ERROR(920, "E00926", "Receipt Error"),						//카드사 응답 오류: 접수결과 오류

	/* Common : 999
	 * AbstractEdocAction : 001
	 * CreatePdfAction : 002
	 * CreateTsaAction : 003
	 * CreateImageAction : 004
	 * SendEcmAction : 005
	 */
	PDF_CREATE_ERROR(500, "E00201", "Pdf Create Error"),
	PDF_CREATE_MODULE_ERROR(500, "E00202", "Pdf Moudule Error"),
	XML_FILE_NOT_FOUND2(500, "E00203", "XML File Not Found"),

	TSA_CREATE_ERROR(500, "E00301", "TSA PDF Create Error"),
	TSA_CREATE_MODULE_ERROR(500, "E00302", "TSA PDF Create Module Error"),
	TSA_CONFIG_FILE_LOAD_ERROR(500, "E00303", "TSA Config File Load Error"),
	PDF_FILE_NOT_FOUND(500, "E00304", "PDF File Not Found"),
	
	IMG_CREATE_ERROR(500, "E00401", "Image Create Error"),
	IMG_CREATE_MODULE_ERROR(500, "E00402", "Image Create Module Error"),
	IMG_CONVERT_MODULE_ERROR(500, "E00403", "Image Convert Error"),
	IMG_MERGE_MODULE_ERROR(500, "E00404", "Image Merge Error"),
	IMG_PAGE_COUNT_ERROR(500, "E00405", "Image Page Count Error"),
	
	ECM_FILE_NOT_FOUND(500, "E00501", "File Not Found"),
	ECM_SEND_ERROR(500, "E00502", "ECM Send Error"),
	ECM_INFO_REGIST_ERROR(500, "E00503", "Ecm Info Regist Error"),
	ECM_MAINKEY_NOT_FOUND(500, "E00504", "Ecm Main Key Not Found"),
	
	//jhmin 20240405
	IDCD_SEND_ERR0R(500, "E00681", "IdCard Send Error"),
	EMAIL_SEND_ERR0R(500, "E00691", "Email Send Error"),
	EDOC_HST_REG_ERR0R(500, "E00711", "EDoc History Regist Error"),
	
	SQL_ERROR2(500, "E99901", "SQL Error"),
	FILE_NOT_FOUND(500, "E99902", "File Not Found"),
	FILE_DELETE_ERROR(500, "E99903", "File Delete Error")
	;
	
	
	private final int statusCode;

	private final String resultCode;
	
	private final String resultMessage;
	
	private EdsStatus(int statusCode, String resultCode, String resultMessage) {
		this.statusCode = statusCode;
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}
	
	public int getStatus() {
		return statusCode;
	}
	
	public String getCode() {
		return resultCode;
	}
	
	public String getMessage() {
		return resultMessage;
	}

}
