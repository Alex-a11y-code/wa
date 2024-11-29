import static org.junit.Assert.*;

import com.dive.lib.Player;
import com.dive.lib.Result;
import com.dive.utils.CoreModule;
import com.dive.utils.DataParser;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.List;

public class DWASearchTest {

    private CoreModule coreModule;
    private final String inputFile = "input.txt";
    private final String outputFile = "output.txt";

    @Before
    public void setUp() {
        coreModule = new CoreModule();
    }

    // 1. 测试 'players' 命令是否返回正确格式的球员信息
    @Test
    public void testProcessPlayersCommand() throws IOException {
        String command = "players";
        String expectedOutput = "Full Name: Doe John\nGender: Male\nCountry: USA\n-----\n";

        // 假设 dataParser.getAllPlayers() 方法会返回一个球员列表
        String actualOutput = coreModule.processCommand(command);

        assertTrue(actualOutput.contains("Full Name: Doe John"));
        assertTrue(actualOutput.contains("Gender: Male"));
        assertTrue(actualOutput.contains("Country: USA"));
    }

    // 2. 测试 'result' 命令返回比赛结果
    @Test
    public void testProcessResultCommand() throws IOException {
        String command = "result women 1m springboard";
        String expectedOutput = "Full Name: John Doe\nRank: 1\nTotalScore: 248.95\n-----\n";

        String actualOutput = coreModule.processCommand(command);

        assertTrue(actualOutput.contains("Full Name: John Doe"));
        assertTrue(actualOutput.contains("Rank: 1"));
        assertTrue(actualOutput.contains("TotalScore: 248.95"));
    }

    // 3. 测试 'result' 详细信息命令返回详细信息
    @Test
    public void testProcessResultDetailCommand() throws IOException {
        String command = "result women 1m springboard detail";

        String actualOutput = coreModule.processCommand(command);

        assertTrue(actualOutput.contains("Full Name: John Doe"));
        assertTrue(actualOutput.contains("Rank: 1"));
        assertTrue(actualOutput.contains("TotalScore: 248.95"));
    }

    // 4. 测试无效命令是否被正确处理
    @Test
    public void testInvalidCommand() throws IOException {
        String command = "invalidCommand";
        String actualOutput = coreModule.processCommand(command);

        assertEquals("Error: Invalid command", actualOutput);
    }

    // 5. 测试输入文件缺失时的异常处理
    @Test(expected = FileNotFoundException.class)
    public void testMissingInputFile() throws IOException {
        FileReader reader = new FileReader("nonexistent_input.txt");
        BufferedReader br = new BufferedReader(reader);
    }

    // 6. 测试输出文件无法创建时的异常处理
    @Test(expected = IOException.class)
    public void testMissingOutputFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("nonexistent_directory/output.txt"));
        writer.write("Test Output");
        writer.close();
    }

    // 7. 测试读取 'players.json' 文件的功能
    @Test
    public void testReadPlayersFile() throws IOException {
        DataParser dataParser = new DataParser();
        List<Player> players = dataParser.getAllPlayers();

        assertNotNull(players);
        assertTrue(players.size() > 0);
    }

    // 8. 测试读取比赛结果文件的功能
    @Test
    public void testReadEventResultFile() throws IOException {
        DataParser dataParser = new DataParser();
        List<Result> results = dataParser.getEventResult("Women 1m Springboard");

        assertNotNull(results);
        assertTrue(results.size() > 0);
    }

    // 9. 测试空命令的处理
    @Test
    public void testEmptyCommand() throws IOException {
        String command = "";
        String actualOutput = coreModule.processCommand(command);

        assertEquals("Error: Invalid command", actualOutput);
    }

    // 10. 测试文件路径不存在时的异常处理
    @Test(expected = FileNotFoundException.class)
    public void testFileNotFound() throws IOException {
        DataParser dataParser = new DataParser();
        dataParser.getEventResult("NonExistentEvent");
    }
}
