package manager;

import models.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> boardCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\julia\\Documents\\QA\\QA_Automation\\QA\\New_Test\\src\\test\\resources\\data.csv")));
        reader.readLine();
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    Board.builder().title(split[0]).build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}







