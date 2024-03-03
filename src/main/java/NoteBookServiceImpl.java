
import java.util.Map;
import java.util.Scanner;


public class NoteBookServiceImpl implements NoteBookService{

    private final NoteBookRepo noteBookRepo = new NoteBookRepo();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void getAllNoteBook() {
        System.out.println(noteBookRepo.addNote());
    }


    private String getCriteria() {
        String criteria = null;
        System.out.println("Выберите фильтр: 1 - ОЗУ, 2 - HDD");
        int criteriaNum = scanner.nextInt();
        Map<Integer, String> criteriaMap = noteBookRepo.addCriteria();
        for (Integer i: criteriaMap.keySet()) {
            if (criteriaNum == i) {
                criteria = criteriaMap.get(i);
            }
        }
        return criteria;
    }

    private int getCriteriaParam() {
        int paramCriteria = 0;
        String criteria = getCriteria();
        if (criteria.equals("ramVolume")) {
            System.out.println("Введите параметр для ОЗУ: 4096 или 8192");
        }
        if (criteria.equals("hddVolume")) {
            System.out.println("Введите параметр для HDD: 120, 240 или 1000");
        }
        Map<Integer, String> criteriaParamMap = noteBookRepo.addParamCriteria();
        int inputParam = scanner.nextInt();
        for (Map.Entry<Integer, String> item: criteriaParamMap.entrySet()) {
            if (item.getValue().equals(criteria) && item.getKey() == inputParam) {
                paramCriteria = item.getKey();
                return paramCriteria;
            }
        }
        return paramCriteria;
    }

    @Override
    public void getNoteBookByCriteria() {
        int paramCriteria = getCriteriaParam();
        for (Notebook n: noteBookRepo.addNote()) {
            if (n.getRamVolume() == paramCriteria) {
                System.out.println(n);
            }
            if (n.getHddVolume() == paramCriteria) {
                System.out.println(n);
            }
        }
    }
}
