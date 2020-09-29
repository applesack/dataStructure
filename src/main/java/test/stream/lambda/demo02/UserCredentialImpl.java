package test.stream.lambda.demo02;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 12:00
 */
public class UserCredentialImpl implements IUserCredential {
    @Override
    public String verifyUser(String username) {
        if ("admin".equals(username)) {
            return "系统管理员";
        } else if ("manage".equals(username)) {
            return "用户管理员";
        }
        return "普通会员";
    }
}
