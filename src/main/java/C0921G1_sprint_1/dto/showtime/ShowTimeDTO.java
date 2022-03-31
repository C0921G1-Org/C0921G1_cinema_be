package C0921G1_sprint_1.dto.showtime;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.model.showtime.Screen;

public class ShowTimeDTO {
    private Integer id;
    private String date;
    private String name;
    private Screen screen;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
