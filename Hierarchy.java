package Homework10;

public class Hierarchy {
    //Попробуйте воспроизвести иерархию классов на уровнях страна-штат-город (например, для Германии), попробуйте подобрать примеры для создания интерфейса для такой иерархии. Создайте по пару экземпляров для каждого из классов
    public static void main(String[] args) {
        Germany germany = new Germany();

        System.out.println(germany.summarise());



        Bayern bayern = new Bayern();

        bayern.setCapital("Munich");
        bayern.setPopulation(13.08);
        System.out.println(bayern.summarise());




        Munich munich = new Munich();

        munich.setPopulation(1.47);
        munich.setCapital(" - ");

        System.out.println(munich.summarise());
        System.out.println(munich.travelThere());
    }

    public static class Germany implements fullWaySequence {
        private String language = "German";
        private int unityYear = 1990;
        private double population = 83.2;
        private String capital = "Berlin";

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getUnityYear() {
            return unityYear;
        }

        public void setUnityYear(int unityYear) {
            this.unityYear = unityYear;
        }

        public double getPopulation() {
            return population;
        }

        public void setPopulation(double population) {
            this.population = population;
        }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public String summarise() {
            return getClass().getSimpleName() + " -> Language - " + language + ", unity year - " + unityYear + ", population - " + population + ", capital - " + capital + ".";
        }


        @Override
        public String travelThere() {
            return "We are in Germany, Berlin, but it's not our destination.";
        }
    }

    public static class Bayern extends Germany {

        @Override
        public String travelThere() {
            return super.travelThere() + " We are so close to our destination, we have already crossed the Bayern state.";
        }
    }

    public static class Munich extends Bayern {
        @Override
        public String travelThere() {
            return super.travelThere() + " We are finally in Munich, let's enjoy the city!";
        }
    }

    interface fullWaySequence {
       String travelThere();
    }

}
