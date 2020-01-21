package by.jwdc.finances.dao.util;

import by.jwdc.finances.dao.exception.DaoUtilException;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    public final static FileUtil instance = new FileUtil();

    private FileUtil() {
    }

    ;

    public static ArrayList<String> readFile(File file) throws DaoUtilException {

        ArrayList<String> fileContentByRows = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                    fileContentByRows.add(tmp);
            }
        } catch (IOException e) {
            throw new DaoUtilException("File not found", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new DaoUtilException("Can't close reader", e);
                }
            }
        }

        return fileContentByRows;
    }

    public static boolean rewriteFile(File file, ArrayList<String> newContent) throws DaoUtilException {

        if (newContent == null){
            throw new DaoUtilException("New content is null");
        }
        if (file == null){
            throw new DaoUtilException("File is null");
        }

        boolean res = false;

        FileWriter fw = null;
        try {
            fw = new FileWriter(file, false);
        } catch (IOException e) {
            throw new DaoUtilException("File not found", e);
        }

        BufferedWriter bw = new BufferedWriter(fw);

        PrintWriter pw = new PrintWriter(bw);

        for (String s : newContent)
            pw.println(s);
        pw.close();

        return res;
    }

    public static void addRecordToFile(File file, String newRecord) throws DaoUtilException {

        if (newRecord == null){
            throw new DaoUtilException("New record is null");
        }
        if (file == null){
            throw new DaoUtilException("File is null");
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            throw new DaoUtilException("File not found", e);
        }
        BufferedWriter bw = new BufferedWriter(fw);

        PrintWriter pw = new PrintWriter(bw);

        pw.print("\n");
        pw.print(newRecord);
        pw.close();
    }
}
