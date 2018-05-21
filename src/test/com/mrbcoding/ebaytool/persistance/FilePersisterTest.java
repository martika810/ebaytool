package com.mrbcoding.ebaytool.persistance;

import com.mrbcoding.ebaytool.domain.Product;
import com.mrbcoding.ebaytool.domain.ProductMutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by rsm095 on 21/05/2018.
 */
public class FilePersisterTest {


    @Test
    public void ifAllParameterGood_loadFromFile_success(){
        ProductMutable mutable = new ProductMutable(UUID.randomUUID().toString(),"Product2",22.3F,22.3F,"INTRANSIT");

        FilePersister.persist("product_test.json",mutable);
        ProductMutable retrievedObject = FilePersister.loadFromFile("product_test.json",ProductMutable.class);
        assert(retrievedObject.getId().equals(mutable.getId()));
        assert(retrievedObject.getName().equals(mutable.getName()));
        assert(retrievedObject.getNetPrice()==mutable.getNetPrice());
        assert(retrievedObject.getFinalPrice()==mutable.getFinalPrice());
        assert(retrievedObject.getStatus().equals(mutable.getStatus()));

        try {
            FileUtils.forceDelete(new File("product_test.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ifAllParametersGood_persistList_success(){
        ProductMutable mutable1 = new ProductMutable(UUID.randomUUID().toString(),"Product1",22.3F,22.3F,"INTRANSIT");
        ProductMutable mutable2 = new ProductMutable(UUID.randomUUID().toString(),"Product2",22.3F,22.3F,"INTRANSIT");
        ProductMutable mutable3  = new ProductMutable(UUID.randomUUID().toString(),"Product3",22.3F,22.3F,"INTRANSIT");

        List<ProductMutable> list= Arrays.asList(mutable1,mutable2,mutable3);
        FilePersister.persist("product_list_test.json",list);
       // List<ProductMutable> retrievedObjects = FilePersister.loadListFromFile("product_list_test.json",List.class);
        List<ProductMutable> retrievedObjects = null;
        assert(retrievedObjects.size()==list.size());
        assert(((ProductMutable)retrievedObjects.get(0)).getId().equals(list.get(0).getId()));
        assert(retrievedObjects.get(1).getId().equals(list.get(1).getId()));
        assert(retrievedObjects.get(2).getId().equals(list.get(2).getId()));
    }
}
