package demo.component;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月15日 23:41
 */
public class ErrorCommandException extends Exception {

    public ErrorCommandException() {
        super();
    }

    public ErrorCommandException(String message) {
        super(message);
    }

    public ErrorCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCommandException(Throwable cause) {
        super(cause);
    }

}
