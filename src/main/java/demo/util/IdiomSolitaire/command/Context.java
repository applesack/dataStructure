package demo.util.IdiomSolitaire.command;

import demo.util.IdiomSolitaire.LoaderUtil;
import demo.util.IdiomSolitaire.WordMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月26日 20:14
 */
public class Context {

    private StringBuilder commandLine = new StringBuilder();

    private WordMap wordMap = LoaderUtil.getWordMap();

    private StringBuilder sb = new StringBuilder();

    public void nextCommand(String command) {

    }

    private List<Interpreter> assembly(String command) {
        List<Interpreter> interpreterList = new ArrayList<>();

        Iterator<Interpreter> iterator = operations.iterator();

        // 命令不为空，并且还有命令没有被解析
        while (!command.isBlank() && iterator.hasNext()) {
            int barIdx = command.indexOf('-');
            if (barIdx == -1)
                break;
            sb.setLength(0);

        }

        return interpreterList;
    }

    private static List<Interpreter> operations;

    static {
        operations = new ArrayList<>();
        operations.add(new NextInterpreter());
    }

    private static class NextInterpreter extends Interpreter {

        int size;
        String commandName = "next";

        public NextInterpreter() {
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        void interpreter(int index) {

        }

        @Override
        void execution() {

        }
    }

}
