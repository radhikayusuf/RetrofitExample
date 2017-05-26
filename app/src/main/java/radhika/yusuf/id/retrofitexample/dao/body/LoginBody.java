package radhika.yusuf.id.retrofitexample.dao.body;

/**
 * Created by Radhika Yusuf on 27/05/17.
 */

public class LoginBody {
    /**
     * nama variable harus sama kaya
     * buat body nya
     * ini buat
     * $_POST['username'];
     * $_POST['password'];
     */

    private String username;
    private String password;

    public LoginBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
