

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoteBookRepo {

    private final Set<Notebook> notebookSet = new HashSet<>();
    private final Map<Integer,String> criteriaMap = new HashMap<>();
    private final Map<Integer,String> criteriaParamMap = new HashMap<>();

    public Set<Notebook> addNote() {
        notebookSet.add(new Notebook(111,"HP", "hp15qw", 4096,
                120, "noOS", "grey"));
        notebookSet.add(new Notebook(222,"ASUS", "b1505cg", 4096,
                240, "Windows10", "black"));
        notebookSet.add(new Notebook(333,"Lenovo", "15IR34", 8192,
                1000, "Linux", "white"));
        return notebookSet;
    }

    public Map<Integer,String> addCriteria() {
        criteriaMap.put(1,"ramVolume");
        criteriaMap.put(2,"hddVolume");
        return criteriaMap;
    }

    public Map<Integer,String> addParamCriteria() {
        criteriaParamMap.put(4096,"ramVolume");
        criteriaParamMap.put(8192,"ramVolume");
        criteriaParamMap.put(120,"hddVolume");
        criteriaParamMap.put(240,"hddVolume");
        criteriaParamMap.put(1000,"hddVolume");
        return criteriaParamMap;
    }

}
