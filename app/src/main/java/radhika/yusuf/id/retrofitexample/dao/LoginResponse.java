package radhika.yusuf.id.retrofitexample.dao;

/**
 * Created by Radhika Yusuf on 27/05/17.
 */

public class LoginResponse extends BaseResponseDao<LoginResponse.LoginData>{


    public class LoginData {
        /**
         * "id_user": 7,
         "first_name": "naahaa",
         "last_name": "ajaha",
         "username": "admin",
         "password": "202cb962ac59075b964b07152d234b70",
         "bdate": "6-9-2004",
         "gender": 1,
         "phone": "645544987"
         */
        private int id_user;
        private String first_name;
        private String last_name;
        private String username;
        private String password;
        private String bdate;
        private int gender;
        private String phone;

        public int getId_user() {
            return id_user;
        }

        public void setId_user(int id_user) {
            this.id_user = id_user;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getBdate() {
            return bdate;
        }

        public void setBdate(String bdate) {
            this.bdate = bdate;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
