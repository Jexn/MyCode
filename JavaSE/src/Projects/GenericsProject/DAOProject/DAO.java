package Projects.GenericsProject.DAOProject;

import java.util.*;

public class DAO <T> {
    private Map<String,T> map;

    public DAO() {
        this.map = new HashMap<>();
    }

    public void save(String id, T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        map.put(id,entity);
    }

    public List<T> list(){
        List<T> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
