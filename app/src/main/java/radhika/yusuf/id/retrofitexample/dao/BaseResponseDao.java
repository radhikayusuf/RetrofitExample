package radhika.yusuf.id.retrofitexample.dao;

import java.util.List;

/**
 * Created by Radhika Yusuf on 27/05/17.
 */

public class BaseResponseDao<T> {
    /**
     * Ini harus sama kaya response API
     * {
     "status": true,
     "status_code": 200,
     "message": "data found",
     "data": [
         {
             "id_user": 7,
             "first_name": "naahaa",
             "last_name": "ajaha",
             "username": "admin",
             "password": "##########",
             "bdate": "6-9-2004",
             "gender": 1,
             "phone": "645544987"
         }
     ]
     }
     *
     */

    private boolean status;
    private int status_code;
    private String message;
    private List<T> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
