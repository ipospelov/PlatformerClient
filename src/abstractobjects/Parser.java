package abstractobjects;


import Base.Coord;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {

    private static GameObjectAbstractFactory factory = new GameObjectAbstractFactory();

    /**
     * File view:
     *  ____________ _____________ ________
     * |    name    |    value    |  type  |
     * |------------|-------------|--------|
     * | name       |     ***     | String |
     * |------------|-------------|--------|
     * | level      | level 0     | String |
     * | level      | ...         | String |
     * |------------|-------------|--------|
     * | mediaFile  | mediaFile 0 | String |
     * | mediaFile  | ...         | String |
     *  ‾‾‾‾‾‾‾‾‾‾‾‾ ‾‾‾‾‾‾‾‾‾‾‾‾‾ ‾‾‾‾‾‾‾‾
     *  Example:
     *      name Mario
     *      level First.lvl
     *      level Second.lvl
     *      level Secret.lvl
     *      mediaFile MarioStand.png
     *      mediaFile GrassBlock.png
     *  Result:
     *      name = "Mario";
     *      levels = { "First", "Second", "Secret" };
     *      mediaFiles = { "MarioStand.png", "GrassBlock.png" };
     */
    public static Project getProject(InputStream stream) {
        Project project = new Project("project");

        Scanner scanner = new Scanner(stream);
        while (scanner.hasNext()) {
            String line[] = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "name":
                    project.setName(line[1]);
                    break;

                case "level":
                    project.addLevel(line[1]);
                    break;

                case "mediaFile":
                    project.addMediaFile(line[1]);
            }
        }

        return project;
    }

    /**
     * File view:
     *  ____________ _____________ ______________________________
     * |    name    |    value    |             type             |
     * |------------|-------------|------------------------------|
     * | name       |     ***     | String                       |
     * | width      |     ***     | int                          |
     * | height     |     ***     | int                          |
     * | theme      |     ***     | String                       |
     * | background |     ***     | String                       |
     * | type       |     ***     | int int String[]             |
     * | ... ... ... ... ... ... ... ... ... ... ... ... ... ... |
     * | type       |     ***     | int int String[]             |
     *  ‾‾‾‾‾‾‾‾‾‾‾‾ ‾‾‾‾‾‾‾‾‾‾‾‾‾ ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
     *  Example:
     *      name Dungeon
     *      height 10
     *      point 1 1 ENTRY
     *      point 75 8 EXIT
     *      block 0 0 HellBlock.png
     *      block 1 0 HellBlock.png
     *      character 2 0 ZombieStand.png ZombieRun1.png ZombieRun2.png
     *  Result:
     *      name = "Dungeon";
     *      width = DEFAULT_WIDTH;
     *      height = 10;
     *      gameObjects = { { Coord : { 0, 0 }, Block : { "HellBlock.png" } },
     *                      { Coord : { 1, 0 }, Block : { "HellBlock.png" } },
     *                      { Coord : { 1, 1 }, Point : { "ENTRY" } },
     *                      { Coord : { 2, 0 }, Character : { "ZombieStand.png", ... } },
     *                      { Coord : { 75, 8 }, Point : { "EXIT" } };
     *      theme = null;
     *      background = null;
     */
    public static Level getLevel(InputStream stream) {
        Level level = new Level("level");

        Scanner scanner = new Scanner(stream);
        while (scanner.hasNext()) {
            String line[] = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "name":
                    level.setName(line[1]);
                    break;

                case "width":
                    level.setWidth(Integer.decode(line[1]));
                    break;

                case "height":
                    level.setHeight(Integer.decode(line[1]));
                    break;

                case "theme":
                    level.setTheme(line[1]);
                    break;

                case "background":
                    level.setBackground(line[1]);
                    break;

                default:
                    Coord coord = new Coord(Integer.decode(line[1]),
                                            Integer.decode(line[2]));
                    String args[] = Arrays.copyOfRange(line, 3, line.length);
                    level.addGameObject(line[0], coord, args);
            }
        }

        return level;
    }
}
