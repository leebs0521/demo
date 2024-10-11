# API 명세서

## 1. 사용자 관련 API

### Get All Users
- **URL**: `/users`
- **Method**: `GET`
- **Response**:
  - **Status 200**: 
    ```json
    {
      "users": ["user1", "user2", ...]
    }
    ```

---

## 2. 제품 관련 API

### Get All Products
- **URL**: `/products`
- **Method**: `GET`
- **Query Parameters**:
  - `sort` (optional): 정렬 기준 (`id`, `name`, `price`)
- **Response**:
  - **Status 200**: 
    ```json
    {
      "products": [{"name": "product1", "price": 100}, ...]
    }
    ```
  - **Status 400**: 
    ```json
    {
      "error": "invalid sort"
    }
    ```

### Get Product by ID
- **URL**: `/products/{id}`
- **Method**: `GET`
- **Response**:
  - **Status 200**: 
    ```json
    {
      "name": "product1",
      "price": 100
    }
    ```
  - **Status 404**: 
    ```json
    {
      "error": "product not found"
    }
    ```

### Get Products by Category ID
- **URL**: `/products/category/{id}`
- **Method**: `GET`
- **Query Parameters**:
  - `sort` (optional): 정렬 기준 (`id`, `name`, `price`)
- **Response**:
  - **Status 200**: 
    ```json
    {
      "products": [{"name": "product1", "price": 100}, ...]
    }
    ```
  - **Status 400**: 
    ```json
    {
      "error": "invalid sort"
    }
    ```
  - **Status 404**: 
    ```json
    {
      "error": "category not found"
    }
    ```

---

## 3. 카테고리 관련 API

### Get All Categories
- **URL**: `/categories`
- **Method**: `GET`
- **Query Parameters**:
  - `sort` (optional): 정렬 기준 (`id`, `name`)
- **Response**:
  - **Status 200**: 
    ```json
    {
      "categories": ["category1", "category2", ...]
    }
    ```
  - **Status 400**: 
    ```json
    {
      "error": "invalid sort"
    }
    ```

### Get Category by ID
- **URL**: `/categories/{id}`
- **Method**: `GET`
- **Response**:
  - **Status 200**: 
    ```json
    {
      "name": "category1"
    }
    ```
  - **Status 404**: 
    ```json
    {
      "error": "category not found"
    }
    ```

---

## 4. 리뷰 관련 API

### Get Reviews for a Product
- **URL**: `/reviews/product/{id}`
- **Method**: `GET`
- **Query Parameters**:
  - `page` (optional, default: 0): 페이지 번호
  - `limit` (optional, default: 10): 한 페이지에 표시할 리뷰 수
- **Response**:
  - **Status 200**: 
    ```json
    {
      "reviews": [{"content": "review content", "user_name": "user1"}, ...]
    }
    ```
