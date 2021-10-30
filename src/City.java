public class City extends Location{

    public City(String[] options, Game rpg) {
        super(options, rpg);
    }

    @Override
    void command1() {
        //Tienda
        rpg.setActualPlace("tienda");
        // esto podria modificar una variable en el manager que determine el lugar
        //de pronto un hashmap
    }

    @Override
    void command2() {
        //Herrero
    }

    @Override
    void command3() {
        //Ir a Mision
    }
}
