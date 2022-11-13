# Interview Questions

**Q. Explain Java Memory Model?**

A. See [Java Memory Model](JAVA_MEMORY_MODEL.md)

**Q. What is the use of the volatile keyword?**

A. 

**Q. FixedThreadPool vs CachedThreadPool?**

A. 

**Q. Serialization in Java?**

`JSON` is a format that encodes objects in a string. Serialization means to convert an object into that string, and deserialization is its inverse operation.

When transmitting data or storing them in a file, the data are required to be byte strings, but complex objects are seldom in that format. Serialization can convert these complex objects into byte strings for such use. After the byte strings are transmitted, the receiver will have to recover the original object from the byte string. This is known as deserialization.

Say, you have an object:

```json
{
  "foo": [1, 4, 7, 10],
  "bar": "baz"
}
```

serializing into `JSON` will convert it into a string:

```text
'{"foo":[1,4,7,10],"bar":"baz"}'
```

which can be stored or sent through wire to anywhere. The receiver can then deserialize this string back to get the original object.