
@SpringBootTest
public class ItemTest {
    @Autowired
    private ItemRepository itemRepository;

    private ItemEntity entity;

    entity = new ItemEntity();
    entity.setName("itemTest");
    entity.setWeight(1.0);
    entity.setPrice(10.0)

    @Test
    void saveItem(ItemEntity entity) {
        ItemEntity entitySave = itemRepository.save(entity);
        assertThat(entitySave).isNotNull();
        assertThat(entitySave.getId()).isGreaterThan(0);
        assertThat(entitySave.getName()).equals("itemTest");
    }
}