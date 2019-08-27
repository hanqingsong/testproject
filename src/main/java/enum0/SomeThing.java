package enum0;

class Resource{
    public Resource() {
        System.out.println("Resource.Resource");
    }
}

public enum SomeThing {
    INSTANCE,INSTANCE2;

    private Resource instance;
    SomeThing() {
        System.out.println("SomeThing 构造器");
        instance = new Resource();
    }
    public Resource getInstance() {
        return instance;
    }
}

class run{
    public static void main(String[] args) {
        SomeThing instance1 = SomeThing.INSTANCE;
        Resource instance = instance1.getInstance();
        Resource instance2 = instance1.getInstance();
        System.out.println("run.main");
    }
}
