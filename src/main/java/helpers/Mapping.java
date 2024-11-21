package helpers;

import model.Mappable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.lang.reflect.Field;

@Mapper
public interface Mapping {

   // Mapping INSTANCE = Mappers.getMapper(Mapping.class);

    // Generic method to map any entity to its DAO
   // <T extends Mappable, U extends Mappable> U entityToDao(T entity);

    // Generic method to map any DAO to its entity
   // <T extends Mappable, U extends Mappable> T daoToEntity(U dao);


    // Generic method to map fields of source object to target object
    public static <T, U> U mapObject(T source, Class<U> targetClass) throws IllegalAccessException, InstantiationException {
        U targetObject = targetClass.newInstance(); // Create new instance of the target class

        // Get all fields of the source object
        Field[] sourceFields = source.getClass().getDeclaredFields();

        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true); // Make the source field accessible

            // Get the value of the field in the source object
            Object value = sourceField.get(source);

            try {
                // Try to map the value to the corresponding field in the target object
                Field targetField = targetClass.getDeclaredField(sourceField.getName());

                targetField.setAccessible(true); // Make the target field accessible
                targetField.set(targetObject, value); // Set the value in the target object
            } catch (NoSuchFieldException e) {
                // If the field does not exist in the target, we simply skip it
            }
        }
        return targetObject;
    }


}
