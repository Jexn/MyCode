package Day01;

public class DaoFactory {
    private static Dao dao = null;

    public Dao getDaoInstance(){
        if (dao == null){
            synchronized (Dao.class){
                if (dao == null){
                    dao = new Dao("JDBC",1);
                }
            }
        }
        return dao;
    }
}
