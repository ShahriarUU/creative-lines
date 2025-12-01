package com.creative_lines.contains.db;

public class DbConstants {

    DbConstants(){

    }

    public static class Common {
        public static final String ID = "id";
        public static final String SEQUENCE_NAME = "entity_sequence";
        public static final String CREATED_AT = "created_at";
        public static final String CREATED_BY = "created_by";
        public static final String UPDATED_AT = "updated_at";
        public static final String UPDATED_BY = "updated_by";
    }

    public static class User extends Common {
        public static final String TABLE_NAME = "user";
        public static final String SEQUENCE_NAME = "user_sequence";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String ROLE = "role";
        public static final String STATUS = "status";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String POSITION = "position";
        public static final String PHONE = "phone";
        public static final String PROFILE_IMAGE = "profile_image";
        public static final String SUBSCRIPTION_TYPE = "subscription_type";
    }
}
