# Mutation

## authenticationUserCreate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
    authenticationUserCreate(
        input: {
            username: "ccc",
            password: "aaa",
            roleKeys: ["Admin"],
            memo: ""
        }
    ) {
        code
        username
        memo
        version
    }
}
```

</details>

## locationCreate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
  locationCreate(
    input: {name: "s", contact: {phoneNumber: "xyz789", mailAddress: "abc123"}, address: {postalCode: "abc123", prefectureCode: 987, address1: "xyz789", address2: "abc123", address3: "abc123", streetAddress: "abc123", buildingName: "abc123", supplement: "abc123"}, hours: {supplement: "abc123"}, memo: ""}
  ) {
    code
    name
    contact {
      phoneNumber
      mailAddress
    }
    address {
      postalCode
      prefectureCode
      prefectureLabel
      address1
      address2
      address3
      streetAddress
      buildingName
      supplement
    }
    openDate
    closeDate
    hours {
      openingTime
      closingTime
      supplement
    }
    memo
    version
  }
}
```

</details>

## locationUpdate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
    locationUpdate(
        code: ""
        input: {name: "", contact: {phoneNumber: "", mailAddress: ""}, address: {postalCode: "", prefectureCode: 0, address1: "", address2: "", address3: "", streetAddress: "", buildingName: "", supplement: ""}, hours: {supplement: ""}, memo: ""}
        version: 0
    ) {
        code
        name
        contact {
            phoneNumber
            mailAddress
        }
        address {
            postalCode
            prefectureCode
            prefectureLabel
            address1
            address2
            address3
            streetAddress
            buildingName
            supplement
        }
        openDate
        closeDate
        hours {
            openingTime
            closingTime
            supplement
        }
        memo
        version
    }
}
```

</details>

## locationDelete

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
    locationDelete(
        code: ""
        version: 0
    )
}
```

</details>

## noticeCreate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
  noticeCreate(
    input: {locationCode: "", summary: "", detail: "", publicationStartDateTime: null, publicationEndDateTime: null}
  ) {
    code
    location {
      code
      name
      contact {
        phoneNumber
        mailAddress
      }
      address {
        postalCode
        prefectureCode
        prefectureLabel
        address1
        address2
        address3
        streetAddress
        buildingName
        supplement
      }
      openDate
      closeDate
      hours {
        openingTime
        closingTime
        supplement
      }
      memo
      version
    }
    summary,
    detail,
    publicationStartDateTime
    publicationEndDateTime
    version
  }
}
```

</details>

## noticeUpdate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
    noticeUpdate(
        code: ""
        input: {locationCode: "", summary: "", detail: "", publicationStartDateTime: null, publicationEndDateTime: null}
        version: 0
    ) {
        code
        location {
            code
            name
            contact {
                phoneNumber
                mailAddress
            }
            address {
                postalCode
                prefectureCode
                prefectureLabel
                address1
                address2
                address3
                streetAddress
                buildingName
                supplement
            }
            openDate
            closeDate
            hours {
                openingTime
                closingTime
                supplement
            }
            memo
            version
        }
        summary
        detail
        publicationStartDateTime
        publicationEndDateTime
        version
    }
}
```

</details>

## noticeDelete

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
    noticeDelete(
        code: ""
        version: 0
    ) 
}
```

</details>

## castCatCreate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
  castCatCreate(
    input: {name: "abc123", image: "xyz789", type: "abc123", sex: unknown, birthdayDate: null, favorite: "abc123", dislike: "xyz789", prohibition: "abc123", brothers: [], sisters: [], memo: ""}
  ) {
    code
    name
    image
    type
    sex
    birthdayDate
    favorite
    dislike
    prohibition
    brothers
    sisters
    memo
    version
  }
}
```

</details>

## castCreate

<details>
<summary>詳細を開く</summary>

```graphql
mutation {
    castCreate(
        input: {locationCode: "", castCatCode: "", employmentStatus: main, firstAttendanceDate: null, lastAttendanceDate: null, memo: ""}
    ) {
        code
        location {
            code
            name
            contact {
                phoneNumber
                mailAddress
            }
            address {
                postalCode
                prefectureCode
                prefectureLabel
                address1
                address2
                address3
                streetAddress
                buildingName
                supplement
            }
            openDate
            closeDate
            hours {
                openingTime
                closingTime
                supplement
            }
            memo
            version
        }
        castCat {
            code
            name
            image
            type
            sex
            birthdayDate
            favorite
            dislike
            prohibition
            brothers
            sisters
            memo
            version
        }
        employmentStatus
        firstAttendanceDate
        lastAttendanceDate
        memo
        version
        version
    }
}
```

</details>

# Query

## locationSearch

<details>
<summary>詳細を開く</summary>

```graphql
{
  locationSearch(codes: []) {
    code
    name
    contact {
      phoneNumber
      mailAddress
    }
    address {
      postalCode
      prefectureCode
      prefectureLabel
      address1
      address2
      address3
      streetAddress
      buildingName
      supplement
    }
    openDate
    closeDate
    hours {
      openingTime
      closingTime
      supplement
    }
    memo
    version
  }
}
```

</details>

## noticeSearch

<details>
<summary>詳細を開く</summary>

```graphql
{
  noticeSearch(codes: [], locationCodes: []) {
    code
    location {
      code
      name
      contact {
        phoneNumber
        mailAddress
      }
      address {
        postalCode
        prefectureCode
        prefectureLabel
        address1
        address2
        address3
        streetAddress
        buildingName
        supplement
      }
      openDate
      closeDate
      hours {
        openingTime
        closingTime
        supplement
      }
      memo
      version
    }
    publicationStartDateTime
    publicationEndDateTime
    version
  }
}
```

</details>

## castCatSearch

<details>
<summary>詳細を開く</summary>

```graphql
{
  castCatSearch(codes: []) {
    code
    name
    image
    type
    sex
    birthdayDate
    favorite
    dislike
    prohibition
    brothers
    sisters
    memo
    version
  }
}
```

</details>

## castSearch

<details>
<summary>詳細を開く</summary>

```graphql
{
  castSearch(codes: [], locationCodes: []) {
    code
    location {
      code
      name
      contact {
        phoneNumber
        mailAddress
      }
      address {
        postalCode
        prefectureCode
        prefectureLabel
        address1
        address2
        address3
        streetAddress
        buildingName
        supplement
      }
      openDate
      closeDate
      hours {
        openingTime
        closingTime
        supplement
      }
      memo
      version
    }
    castCat {
      code
      name
      image
      type
      sex
      birthdayDate
      favorite
      dislike
      prohibition
      brothers
      sisters
      memo
      version
    }
    employmentStatus
    firstAttendanceDate
    lastAttendanceDate
    memo
    version
    version
  }
}
```

</details>
