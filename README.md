# 概要
java関連で気になった記事などについて、手を動かして確認してみるプロジェクト<br>
Kotlinのハンズオンも本プロジェクトで管理する。<br>

# 各ハンズオンをサブプロジェクトに切り出す
- https://docs.gradle.org/current/userguide/intro_multi_project_builds.html#sec:project_standard
- https://docs.gradle.org/current/userguide/custom_plugins.html#sec:convention_plugins
- https://docs.gradle.org/current/userguide/writing_plugins.html
- https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html
- https://zenn.dev/loglass/articles/6c449ab8a750f2#%E3%83%9E%E3%83%AB%E3%83%81%E3%83%A2%E3%82%B8%E3%83%A5%E3%83%BC%E3%83%AB%E5%8C%96

# TODO
この記事によると、buildSrcは将来的に非推奨となるらしいのでcomposite pluginに変更が必要<br>
- - https://speakerdeck.com/mkeeda/5fen-defen-karubirudorozitukugong-tong-hua-nojin?slide=12