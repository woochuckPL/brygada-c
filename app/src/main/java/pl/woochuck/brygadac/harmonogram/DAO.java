package pl.woochuck.brygadac.harmonogram;

import java.util.List;

public interface DAO {
    void add(Day day);
    List<Day> findAll();
    Day findById(int id);
    boolean updateById(Day day);
}
