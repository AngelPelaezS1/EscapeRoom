package Connections;

import java.util.ArrayList;

public interface ManagerEntities {
    public void add(Object object);
    public void delete(Object object);
    public Object getById(Object object);
    public ArrayList<Object> getAll(Object object);
}