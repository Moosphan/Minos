## Minos
Minos 意为古希腊神话中的审判官，负责最终的判决。本项目为 Android 中常用 Lint 规则的收集和实战，作为代码健康度和鲁棒性的最终保障，Lint 作为最终的"审判官"当之无愧。

## Architecture 
- lint-aar: Publish lint rules as lint.jar into self aar output.
- lint-rules: New usage based on AGP 7.0 about `com.android.lint` plugin.
- lint-rules-old: Old usage to config lint env and write lint codes without features of AGP-7.0.
- app: Just used for testing lint rules and show the real testing environment.

## To do
- [x] Implement custom lint rules samples.
- [x] Write article to show base usage of custom lint.
- [x] Introduce new features of lint since AGP-7.0.
- [ ] Highly configurable lint project without any coding.

## Article reference
- [*Android自定义lint的二三事儿*](https://dorck.cn/android/2022/08/10/android-lint/)