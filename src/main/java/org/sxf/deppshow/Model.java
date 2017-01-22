package org.sxf.deppshow;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sxf on 17-1-21.
 */
public class Model {

    ArrayList<Page> pages = new ArrayList<>();

    public void load(URL url) throws IOException {
        Reader reader = new InputStreamReader(url.openStream());
        load(reader);
    }
    public void load(String path) throws IOException {
        File file = new File(path);
        if (!file.canRead()) throw new FileNotFoundException();
        Reader reader = new FileReader(file);
        load(reader);
    }
    public void load(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        while (br.ready()) {
            Page page = new Page();
            if (!page.load(br)) break;
            pages.add(page);
        }
    }
}

class Page {
    String tokens;
    String token_name;
    String stacks;
    String left;
    String right;
    String position;

    public boolean load(BufferedReader br) throws IOException {
        String s = null;
        while ((s = br.readLine()) != null) {
            if (s.charAt(0)=='-') break;
        }
        if (s == null) return false;
        tokens = br.readLine() + '\n' + br.readLine();
        position = br.readLine();
        token_name = br.readLine();
        stacks = br.readLine() + '\n' + br.readLine() + '\n' + br.readLine();
        left = br.readLine();
        right = br.readLine();
        return true;
    }
}