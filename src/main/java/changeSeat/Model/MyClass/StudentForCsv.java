package changeSeat.Model.MyClass;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class StudentForCsv {

    @CsvBindByName(column = "生徒名", required = true)
    private String studentName;

    @CsvBindByName(column = "性別", required = true)
    private String sexType;
}
