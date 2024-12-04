# 参考
- https://spring.pleiades.io/spring-security/reference/getting-spring-security.html
- https://terasolunaorg.github.io/guideline/current/ja/Security/Encryption.html#encryptionhowtousecommonkey

# memo
saltの値に"salt"を渡したら、以下のエラーで怒られた
```
java.lang.IllegalArgumentException: Detected a Non-hex character at 1 or 2 position
```
-> これは文字列として渡した値が16進数に変換できない文字を使用していたため
　　範囲は1-9, a-f