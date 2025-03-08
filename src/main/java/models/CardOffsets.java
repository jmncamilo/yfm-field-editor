package models;

import java.util.LinkedHashMap;

public class CardOffsets {
    private LinkedHashMap <String, Long> cardBaseOffset;
    private long cardIncrementType = 0;

    public CardOffsets() {
        assignOffsets();
    }

    public void assignOffsets() {
        cardBaseOffset = new LinkedHashMap<>();
        cardBaseOffset.put("Forest", 0x811D4L + cardIncrementType); //Forest x Dragon
        cardBaseOffset.put("Wasteland", 0x811D5L + cardIncrementType); //Wasteland x Dragon
        cardBaseOffset.put("Mountain", 0x811D6L + cardIncrementType); //Mountain x Dragon
        cardBaseOffset.put("Sogen", 0x811D7L + cardIncrementType); //Sogen x Dragon
        cardBaseOffset.put("Umi", 0x811D8L + cardIncrementType); //Umi x Dragon
        cardBaseOffset.put("Yami", 0x811D9L + cardIncrementType); //Yami x Dragon
    }

    public LinkedHashMap <String, Long> getCardBaseOffset() {
        return cardBaseOffset;
    }

    public void setCardIncrement(long cardIncrementType) {
        this.cardIncrementType = cardIncrementType;
        assignOffsets();
    }
}
