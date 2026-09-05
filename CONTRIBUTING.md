# Contributing

In this project we will be using [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/).
Scopes are optional.

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

---

## Types

| Type     | Used when                                    |
|----------|----------------------------------------------|
| feat     | new feature                                  |
| fix      | bugfix                                       |
| docs     | only documentation changes                   |
| style    | formatting changes                           |
| refactor | code restructuring                           |
| test     | adding/changing tests                        |
| chore    | maintenance tasks not covered by other types |
| build    | changes to build system or dependencies      |

---

## Examples

```
feat: app settings page
```

```
refactor: extract Greeting composable into separate file

Splitting MainActivity.kt into smaller composables to keep
responsibilities separated as the UI grows.
```

```
docs(readme): adding contributing section
```

```
fix(build): correct minSdk value in app/build.gradle.kts
```