# softhouse-converter

## Run the converter

You can find the JAR file in `target/person-converter-1.0-SNAPSHOT-jar-with-dependencies.jar`.

To run the converter use the following command

```shell
java -jar target/person-converter-1.0-SNAPSHOT-jar-with-dependencies.jar <input-file> <output-path>
```

## Example
Input: 
```text
P|Elof|Sundin
T|073-101801|018-101801
A|S:t Johannesgatan 16|Uppsala|75330
F|Hans|1967
A|Frodegatan 13B|Uppsala|75325
F|Anna|1969
T|073-101802|08-101802
P|Boris|Johnson
A|10 Downing Street|London
```

Output:
```xml
<people>
    <person>
        <address>
            <street>10 Downing Street</street>
            <city>London</city>
        </address>
        <firstname>Boris</firstname>
        <lastname>Johnson</lastname>
    </person>
    <person>
        <address>
            <street>S:t Johannesgatan 16</street>
            <city>Uppsala</city>
            <zip>75330</zip>
        </address>
        <family>
            <address>
                <street>Frodegatan 13B</street>
                <city>Uppsala</city>
                <zip>75325</zip>
            </address>
            <birthYear>1967</birthYear>
            <name>Hans</name>
        </family>
        <family>
            <birthYear>1969</birthYear>
            <name>Anna</name>
            <phone>
                <landline>073-101802</landline>
                <mobile>073-101802</mobile>
            </phone>
        </family>
        <firstname>Elof</firstname>
        <lastname>Sundin</lastname>
        <phone>
            <landline>073-101801</landline>
            <mobile>073-101801</mobile>
        </phone>
    </person>
</people>
```