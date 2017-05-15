package williams.ben

import org.springframework.stereotype.Service

/**
 * Created by billiams on 3/16/17.
 */
@Service
class Validator {

    Map validateCheese(Cheese cheese){
        // name is not blank and less than 30 characters
        // taste is not blank
        boolean isValid = true
        Map result = [:]
        result["errors"] = []
        if(isBlank(cheese, 'name', result)) isValid = false

        if(cheese.name && cheese.name.length() > 30){
            result["errors"] << ["id": 'name', "message":"Name must be less than 30 characters."]
            isValid = false
        }

        if(isBlank(cheese, 'taste', result)) isValid = false

        result["result"] = isValid

        return result

    }

    private boolean isBlank(Cheese cheese, String field, Map result){
        if(!cheese[field]) {
            result["errors"] << ["id":field, "message":"${field.capitalize()} is required.".toString()]
            return true
        }

        return false
    }

}
