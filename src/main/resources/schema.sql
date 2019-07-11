/*Este fichero es el script que se ejecuta segun la configuracion  aplication.properties  propiedad spring.jpa.hibernate.ddl-auto =  
 * 
 * 	none:para produccion 
 *  create-drop: para dev, se ejecuta el script del fichero  schema.sql
 *  update 
 *  validate
 *  
 * Solo se usa para H2
 * */
CREATE TABLE PROFESSIONAL
(
    CREATION_DATE          TIMESTAMP,
    LAST_MODIFIED_DATE     TIMESTAMP,
    LAST_MODIFIED_BY       varchar(255),
    CREATED_BY             varchar(255),
    PROFESSIONAL_ID IDENTITY PRIMARY KEY,
    NAME                   varchar(255),
    FIRST_LAST_NAME        varchar(255),
    SECOND_LAST_NAME       varchar(255),
    DNI                    varchar(255),
    BIRTH_DATE             TIMESTAMP,
    EMAIL                  varchar(255),
    PHONE_NUMBER           varchar(255),
    CELL_NUMBER            varchar(255),
    WORK_CATEGORY          varchar(255),
    STATE                  varchar(255),
    MIN_WAGE               int,
    MAX_WAGE               int,
    AVAILABILITY           varchar(255),
    COUNTRY                varchar(255),
    PROVINCE               varchar(255),
    CERTIFICATION          varchar(255),
    SPECIALIZATION         varchar(255),
    UNIVERSITY             varchar(255),
    SCORE                  int,
    HAS_FILES              bool,
    BUSINESS_AREA          varchar(255),
    URL                    varchar(255),
    DESCRIPTION            varchar(5000),
    KEYWORDS               varchar(255),
    LAST_MODIFICATION_DATE TIMESTAMP
);

CREATE TABLE POSITION
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    POSITION_ID IDENTITY PRIMARY KEY,
    MANAGER            varchar(255),
    COMPANY            varchar(255),
    UNIT               varchar(255),
    RECRUITER          varchar(255),
    CLIENT             varchar(255),
    WORK_CATEGORY      varchar(255),
    PRIORITY           varchar(255),
    STATE              varchar(255),
    PROJECT            varchar(255),
    NUM_PROFESSIONALS  int,
    RATE               int,
    MIN_WAGE           int,
    MAX_WAGE           int,
    DURATION           varchar(255),
    DESCRIPTION        varchar(5000),
    CERTIFICATION      varchar(255),
    SPECIALIZATION     varchar(255),
    POSITION_DATE      TIMESTAMP,
    INCORPORATION_DATE TIMESTAMP,
    KEYWORDS           varchar(255),
    EXTERNAL_KEY       varchar(255),
    SHORT_DESCRIPTION  varchar(255),
    department         varchar(255)
);

CREATE TABLE PROFESSIONAL_POSITION
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    ASIGNACION_ID IDENTITY PRIMARY KEY,
    PROFESSIONAL_ID    bigint,
    POSITION_ID        bigint,
    FOREIGN KEY (POSITION_ID) REFERENCES POSITION (POSITION_ID),
    FOREIGN KEY (PROFESSIONAL_ID) REFERENCES PROFESSIONAL (PROFESSIONAL_ID),
    UNIQUE (PROFESSIONAL_ID, POSITION_ID)
);

CREATE TABLE CONTACT
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    CONTACT_ID IDENTITY PRIMARY KEY,
    PROFESSIONAL_NAME  varchar(255),
    RECRUITER          varchar(255),
    CONTACT_DATE       TIMESTAMP,
    CURRENT_WAGE       int,
    EXPECTED_WAGE      int,
    STATE              varchar(255),
    INFORMATION        varchar(255),
    AVAILABILITY       varchar(255),
    PROFESSIONAL_ID    bigint,
    VALUATIONS 			varchar](255),
    FOREIGN KEY (PROFESSIONAL_ID) REFERENCES PROFESSIONAL (PROFESSIONAL_ID)
);

CREATE TABLE FILES
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    FILE_ID IDENTITY PRIMARY KEY,
    FILE_NAME          varchar(255),
    FILE_TYPE          varchar(255),
    DATA               blob,
    PROFESSIONAL_ID    bigint
);

CREATE TABLE WORK_EXPERIENCE
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    WORK_ID IDENTITY PRIMARY KEY,
    DESCRIPTION        varchar(5000),
    START_DATE         TIMESTAMP,
    END_DATE           TIMESTAMP,
    STILL_THERE        BOOL,
    CLIENT             varchar(255),
    CATEGORY           varchar(255),
    PROFESSIONAL_ID    bigint,
    FOREIGN KEY (PROFESSIONAL_ID) REFERENCES PROFESSIONAL (PROFESSIONAL_ID)
);

CREATE TABLE KEYWORD
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    KEYWORD_ID IDENTITY PRIMARY KEY,
    KEYWORD            varchar(255)
);

CREATE TABLE SPECIALIZATION
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    SPECIALIZATION_ID IDENTITY PRIMARY KEY,
    CERTIFICATION_ID   BIGINT NOT NULL,
    SPECIALIZATION     varchar(255)
);

CREATE TABLE CLIENT
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    CLIENT_ID IDENTITY PRIMARY KEY,
    CLIENT             varchar(500)
);

CREATE TABLE AGENDA
(
    CREATION_DATE      TIMESTAMP,
    LAST_MODIFIED_DATE TIMESTAMP,
    LAST_MODIFIED_BY   varchar(255),
    CREATED_BY         varchar(255),
    AGENDA_ID IDENTITY PRIMARY KEY,
    TEXT               varchar(1000),
    USERNAME           varchar(255),
    MARKED             BOOL
);
