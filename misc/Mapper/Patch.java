public class Patch {
    ObjectMapper mapper = new ObjectMapper();
    Person person = mapper.treeToValue(jsonNode, Person.class);

}
