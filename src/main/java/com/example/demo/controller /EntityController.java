@RequestMapping("/service")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}