### Hexlet tests and linter status:
[![Actions Status](https://github.com/SNKiii/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/SNKiii/java-project-78/actions)
[![SonarQube](https://github.com/SNKiii/java-project-78/actions/workflows/build.yml/badge.svg)](https://github.com/SNKiii/java-project-78/actions/workflows/build.yml)

Java Validator Library
Библиотека на Java для валидации данных различных типов: строк, чисел и словарей. Позволяет строить гибкие цепочки проверок (Fluent Interface) и создавать сложные схемы валидации объектов.
🚀 Особенности
    Fluent API: удобное построение правил через точку.
    Поддержка различных типов: String, Integer, Map.
    Схемы объектов (Shape): проверка структуры вложенных данных в Map.
    Расширяемость: легко добавить свои типы схем и предикатов.
    
    📖 Примеры использования
Валидация строк

```ruby
Validator v = new Validator();
StringSchema schema = v.string();

schema.required().minLength(5).contains("Battom");

schema.isValid("Battom case"); // true
schema.isValid("Bat");           // false
```

Валидация чисел

'''ruby
NumberSchema schema = v.number();

schema.required().positive().range(10, 20);

schema.isValid(19); // true
schema.isValid(-25); // false
'''

Валидация сложных структур (Shape)

'''ruby
MapSchema<String, String> schema = v.map();

Map<String, BaseSchema<String>> schemas = new HashMap<>();
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

schema.shape(schemas);

Map<String, String> human = new HashMap<>();
human.put("firstName", "John");
human.put("lastName", "D");

schema.isValid(human); // false (lastName слишком короткий)
'''
