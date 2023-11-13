class Device implements Runnable {
    public String name;
    public String type;
    private final Router router;

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    @Override
    public void run() {
        try {
            int id = router.connect(this);
            System.out.println("(" + this.name + ") " + "(" + this.getType() + ") Occupied");
            Thread.sleep(1000);

            performOnlineActivity(id);

            Thread.sleep(1000);
            router.disconnect(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getType(){
        return this.type;
    }

    public void performOnlineActivity(int id){
        System.out.println("Connection " + id + ": " + name + " performs online activity");
    }
//    public void logOut(){
//        System.out.println("Connection " + router.getConnectionId(this) + ": " + name + " Logged out");
//    }

}
