package basic;

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        User user = new User("张三");
        change(user);
        System.out.println(user.name);
    }

    public static void change(User u) {
        User user = new User("李四");
        u = user;
        //u.name = "no body";
    }
}