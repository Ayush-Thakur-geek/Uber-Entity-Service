ALTER TABLE driver
    ADD active_city VARCHAR(255) NULL;

ALTER TABLE driver
    ADD driver_approval_status ENUM('APPROVED','DENIED','PENDING') NULL;

ALTER TABLE driver
    ADD home_id BIGINT NULL;

ALTER TABLE driver
    ADD last_known_location_id BIGINT NULL;

ALTER TABLE driver
    ADD rating DOUBLE NULL;

ALTER TABLE driver
    MODIFY rating DOUBLE NOT NULL;

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_HOME FOREIGN KEY (home_id) REFERENCES exact_location (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_LAST_KNOWN_LOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);

ALTER TABLE driver
    ADD CONSTRAINT check_rating CHECK ( driver.rating >= 0 AND driver.rating <=5);

ALTER TABLE driver
    ADD is_available BOOLEAN NULL;