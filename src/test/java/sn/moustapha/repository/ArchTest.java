package sn.moustapha.repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("sn.moustapha.repository");

        noClasses()
            .that()
            .resideInAnyPackage("sn.moustapha.repository.service..")
            .or()
            .resideInAnyPackage("sn.moustapha.repository.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..sn.moustapha.repository.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
