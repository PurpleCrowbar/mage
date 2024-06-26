package mage.util;

import mage.constants.SubType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubTypes extends ArrayList<SubType> {

    private boolean isAllCreatureTypes = false;
    private boolean isAllNonbasicLandTypes = false;

    public SubTypes(SubType... subTypes) {
        super();
        Collections.addAll(this, subTypes);
    }

    protected SubTypes(final SubTypes list) {
        this.addAll(list);
        this.isAllCreatureTypes = list.isAllCreatureTypes;
        this.isAllNonbasicLandTypes = list.isAllNonbasicLandTypes;
    }

    public SubTypes copy() {
        return new SubTypes(this);
    }

    public boolean add(SubType... subTypes) {
        return Collections.addAll(this, subTypes);
    }

    public void copyFrom(SubTypes subtypes) {
        this.clear();
        this.addAll(subtypes);
        this.isAllCreatureTypes = subtypes.isAllCreatureTypes;
        this.isAllNonbasicLandTypes = subtypes.isAllNonbasicLandTypes;
    }

    public boolean removeAll(SubType... subTypes) {
        return super.removeAll(Arrays.asList(subTypes));
    }

    public void setIsAllCreatureTypes(boolean allCreatureTypes) {
        isAllCreatureTypes = allCreatureTypes;
    }

    public boolean isAllCreatureTypes() {
        return isAllCreatureTypes;
    }

    public void setIsAllNonbasicLandTypes(boolean allNonbasicLandTypes) {
        isAllNonbasicLandTypes = allNonbasicLandTypes;
    }

    public boolean isAllNonbasicLandTypes() {
        return isAllNonbasicLandTypes;
    }
}
