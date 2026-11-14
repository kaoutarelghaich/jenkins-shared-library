# Jenkins Shared Library

Reusable pipeline steps written in Groovy live in `vars/`. Jenkins exposes each
Groovy file there as a pipeline global, named after the file.

For example, `vars/hello.groovy` can be called from a Jenkinsfile with
`hello('Jenkins')`. Supporting Groovy classes can be added under `src/` as the
library grows.