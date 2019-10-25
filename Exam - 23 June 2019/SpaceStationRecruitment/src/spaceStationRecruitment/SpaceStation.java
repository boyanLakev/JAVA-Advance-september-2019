package spaceStationRecruitment;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.getCount() < getCapacity()) {
            this.data.add(astronaut);
        }
    }
    public boolean remove(String name){
       // return this.data.removeIf(e->e.getName().equals(name));
        boolean result=false;
        for (int i = 0; i <this.data.size() ; i++) {
            if(data.get(i).getName().equals(name)){
                result=true;
                this.data.remove(i);
                break;
            }
        }
        return result;
    }
    public Astronaut getOldestAstronaut(){
        Astronaut astronaut;
               /* this.data
                .stream()
                .sorted((a,b)->b.getAge()-a.getAge())
                .findFirst().orElse(null);
*/
        if (this.data==null){
            return null;
        }else {
            astronaut=this.data.get(0);
        }

        for (Astronaut datum : this.data) {
            if(astronaut.getAge()<datum.getAge()){
                astronaut=datum;
            }
        }
        return astronaut;
    }
    public Astronaut getAstronaut(String name){
        Astronaut astronaut=this.data.stream()
                .filter(e-> e.getName().equals(name))
                .findFirst()
                .orElse(null);
        return astronaut;

    }
    public String report(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Astronauts working at Space Station %s:",this.name));
        sb.append(System.lineSeparator());
        for (Astronaut datum : this.data) {
            sb.append(datum.toString());
            sb.append(System.lineSeparator());

        }
        return sb.toString();

    }

}
